package com.vunh.service;

import com.vunh.entity.Hacker;
import com.vunh.repository.HackerRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Data
public class HackerService {
    private List<Hacker> hackers;

    private final List<String> listMajor = Arrays.asList("Hacker", "Security", "Unemployment", "User");

    public HackerService() {
        hackers = new ArrayList<>();
        setHackers(new HackerRepository().findAll());
    }

    public void storeHacker(Hacker hacker) {
        this.hackers.add(hacker);
    }

    public Hacker findHacker(int id) {
        return this.hackers.stream().filter(h -> h.getId() == id).findFirst().orElse(null);
    }

    public void updateHacker(Hacker hacker) {
        this.hackers.stream().filter(h -> Objects.equals(h.getId(), hacker.getId())).findFirst().ifPresent(cute -> {
            cute.setFullName(hacker.getFullName());
            cute.setGender(hacker.getGender());
            cute.setMajor(hacker.getMajor());
        });
    }

    public void deleteHacker(int id) {
        this.hackers.removeIf(h -> h.getId() == id);
    }

    public List<Hacker> getHackers(String keyword) {
        return this.hackers.stream().filter(hkVu -> hkVu.getFullName().contains(keyword)).toList();
    }
}
