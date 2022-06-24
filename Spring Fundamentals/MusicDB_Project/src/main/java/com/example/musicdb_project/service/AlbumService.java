package com.example.musicdb_project.service;

import com.example.musicdb_project.model.Album;
import com.example.musicdb_project.model.Artist;
import com.example.musicdb_project.model.User;
import com.example.musicdb_project.model.dto.AlbumDTO;
import com.example.musicdb_project.model.enums.ArtistNameEnum;
import com.example.musicdb_project.model.enums.GenreNameEnum;
import com.example.musicdb_project.repository.AlbumRepository;
import com.example.musicdb_project.repository.ArtistRepository;
import com.example.musicdb_project.repository.UserRepository;
import com.example.musicdb_project.session.LoggedUser;
import com.example.musicdb_project.view.AlbumViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumService {

    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final AlbumRepository albumRepository;

    public AlbumService(ArtistRepository artistRepository,
                        UserRepository userRepository,
                        LoggedUser loggedUser,
                        AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.albumRepository = albumRepository;
    }

    public boolean addAlbum(AlbumDTO albumDTO) {

        ArtistNameEnum artistName = switch (albumDTO.getArtist()) {
            case "QUEEN" -> ArtistNameEnum.QUEEN;
            case "METALLICA" -> ArtistNameEnum.METALLICA;
            case "MADONNA" -> ArtistNameEnum.MADONNA;
            default -> ArtistNameEnum.QUEEN;
        };

        Artist artist = this.artistRepository.findByName(artistName);

        GenreNameEnum genreName = switch (albumDTO.getGenre()) {
            case "POP" -> GenreNameEnum.POP;
            case "ROCK" -> GenreNameEnum.ROCK;
            case "METAL" -> GenreNameEnum.METAL;
            case "OTHER" -> GenreNameEnum.OTHER;
            default -> GenreNameEnum.POP;
        };

        Optional<User> owner = this.userRepository.findById(this.loggedUser.getId());

        Album album = new Album();
        album.setName(albumDTO.getName());
        album.setReleaseDate(albumDTO.getReleaseDate());
        album.setAddedFrom(owner.get());
        album.setArtist(artist);
        album.setCopies(albumDTO.getCopies());
        album.setDescription(albumDTO.getDescription());
        album.setGenre(genreName);
        album.setPrice(albumDTO.getPrice());
        album.setImgUrl(albumDTO.getImgUrl());

        this.albumRepository.save(album);

        return true;
    }

    public Integer getTotalCopies() {
        return albumRepository.findTotalCopiesSum();
    }

    public List<AlbumViewModel> findAll() {
        return albumRepository.findAll()
                .stream().map(album -> {
                    AlbumViewModel albumViewModel = new AlbumViewModel();
                    albumViewModel.setId(album.getId());
                    albumViewModel.setImgUrl(album.getImgUrl());
                    albumViewModel.setName(album.getName());
                    albumViewModel.setArtist(album.getArtist().getName().name());
                    albumViewModel.setGenre(album.getGenre().name());
                    albumViewModel.setPrice(album.getPrice());
                    albumViewModel.setReleaseDate(album.getReleaseDate());
                    albumViewModel.setCopies(album.getCopies());

                    return albumViewModel;
                }).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        this.albumRepository.deleteById(id);
    }
}
