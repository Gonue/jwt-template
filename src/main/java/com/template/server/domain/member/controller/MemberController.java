package com.template.server.domain.member.controller;

import com.template.server.domain.member.dto.MemberDto;
import com.template.server.domain.member.dto.request.MemberJoinRequest;
import com.template.server.domain.member.dto.response.MemberJoinResponse;
import com.template.server.domain.member.service.MemberService;
import com.template.server.global.error.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response<MemberJoinResponse> join(@Valid @RequestBody MemberJoinRequest request){
        MemberDto memberDto = memberService.join(request.getEmail(), request.getPassword(), request.getNickname());
        return Response.success(201, MemberJoinResponse.from(memberDto));
    }
}
