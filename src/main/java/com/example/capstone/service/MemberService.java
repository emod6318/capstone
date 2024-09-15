package com.example.capstone.service;

import com.example.capstone.dto.MemberDTO;
import com.example.capstone.entity.MemberEntity;
import com.example.capstone.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public MemberDTO login(MemberDTO memberDTO) {
        // 1. 회원이 입력한 이메일로 DB에서 조회.
        // 2. 조회한 비밀번호와 입력한 비밀번호가 일치하는지 판단.
       Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            // 조회 결과 있다. 이메일 있다.
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호 일치.
                // Controller로 넘길 때는 DTO로 넘김.
                // Entity -> DTO 변환 후 리턴.
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 불일치.
                return null;
            }

        } else {
            // 조회 결과 없다. 이메일 없다.
            return null;
        }
    }

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public MemberDTO updateForm(String myEmail) {
        Optional<MemberEntity> optionMemberEntity = memberRepository.findByMemberEmail(myEmail);
        if (optionMemberEntity.isPresent()){
            return MemberDTO.toMemberDTO(optionMemberEntity.get());
        } else {
            return null;
        }
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));
    }

}
