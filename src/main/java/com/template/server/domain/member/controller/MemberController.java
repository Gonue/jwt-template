package com.template.server.domain.member.controller;

import com.template.server.domain.member.dto.MemberDto;
import com.template.server.domain.member.dto.request.MemberJoinRequest;
import com.template.server.domain.member.dto.response.MemberJoinResponse;
import com.template.server.domain.member.service.MemberService;
import com.template.server.global.error.response.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Response<MemberJoinResponse> join(@Valid @RequestBody MemberJoinRequest request){
        MemberDto memberDto = memberService.join(request.getEmail(), request.getPassword(), request.getNickname());
        return Response.success(MemberJoinResponse.from(memberDto));
    }
}
