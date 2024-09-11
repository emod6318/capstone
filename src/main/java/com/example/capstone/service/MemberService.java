package com.example.capstone.service;

import com.example.capstone.dto.MemberDTO;
import com.example.capstone.entity.MemberEntity;
import com.example.capstone.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        // repository의 save 메서드 호출. 조건: entity 객체를 넘겨 줘야함.
        // 1. DTO -> Entity 변환
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);

        // 2. repository의 save 메서드 호출. jpa가 제공해주는 save 메서드 사용.
        memberRepository.save(memberEntity);
    }
}
