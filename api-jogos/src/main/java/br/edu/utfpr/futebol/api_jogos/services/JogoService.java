package br.edu.utfpr.futebol.api_jogos.services;

import br.edu.utfpr.futebol.api_jogos.dtos.EmailRequestDTO;
import br.edu.utfpr.futebol.api_jogos.dtos.JogoRequestDTO;
import br.edu.utfpr.futebol.api_jogos.exceptions.GameFullException;
import br.edu.utfpr.futebol.api_jogos.exceptions.GameNotFoundException;
import br.edu.utfpr.futebol.api_jogos.model.Ingresso;
import br.edu.utfpr.futebol.api_jogos.model.Jogos;
import br.edu.utfpr.futebol.api_jogos.repositories.IngressoRepository;
import br.edu.utfpr.futebol.api_jogos.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private IngressoRepository ingressoRepository;

    @Autowired
    private EmailServiceClient emailServiceClient;

    public List<Jogos> getAllGames() {
        return jogoRepository.findAll();
    }

    public List<Jogos> getUpcomingGames() {
        return jogoRepository.findUpcomingGames(LocalDateTime.now());
    }

    public Jogos createGame(JogoRequestDTO jogoRequest) {
        Jogos newGame = new Jogos(jogoRequest);
        return jogoRepository.save(newGame);
    }

    private Boolean isGameFull(Jogos jogo){
        return jogo.getRegisteredFans() >= jogo.getMaxFans();
    }

    public void registerFan(String jogoId, String torcedorEmail) {
        Jogos jogo = jogoRepository.findById(jogoId).orElseThrow(GameNotFoundException::new);

        if(isGameFull(jogo)) {
            throw new GameFullException();
        }

        Ingresso ingresso = new Ingresso(jogo, torcedorEmail);
        ingressoRepository.save(ingresso);

        jogo.setRegisteredFans(jogo.getRegisteredFans() + 1);

        jogoRepository.save(jogo);

        EmailRequestDTO emailRequest = new EmailRequestDTO(torcedorEmail, "Confirmação de Compra", "A compra do seu ingresso foi efetuada com sucesso!");

        emailServiceClient.sendEmail(emailRequest);
    }
}