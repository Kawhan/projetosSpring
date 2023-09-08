package br.ufpb.dcx.oppfyhub.opportunityhub.controler;

import br.ufpb.dcx.oppfyhub.opportunityhub.dto.JobResponseInterestedUsersDTO;
import br.ufpb.dcx.oppfyhub.opportunityhub.dto.JobTitleRequestDTO;
import br.ufpb.dcx.oppfyhub.opportunityhub.dto.JobRequestDTO;
import br.ufpb.dcx.oppfyhub.opportunityhub.dto.JobResponseDTO;
import br.ufpb.dcx.oppfyhub.opportunityhub.enums.TypeJob;
import br.ufpb.dcx.oppfyhub.opportunityhub.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("v1/api/jobs")
public class JobController {
    @Autowired
    JobService jobService;

    // Gets

    @GetMapping // ok
    @ResponseStatus(code= HttpStatus.OK)
    public List<JobResponseDTO> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("interest")
    @ResponseStatus(code = HttpStatus.OK)
    public List<JobResponseDTO> getAllInterestsFromUser(@RequestHeader("Authorization") String header) {
        return jobService.getAllInterestsFromUser(header);
    }

    @GetMapping("{id}") // ok
    @ResponseStatus(code=HttpStatus.OK)
    public JobResponseDTO getJob(@PathVariable long id) {
        return jobService.getJob(id);
    }

    @GetMapping("titleJob") // ok
    @ResponseStatus(code = HttpStatus.OK)
    public List<JobResponseDTO> getJobByTitleJob(@RequestParam String titleJob) {
        return jobService.getJobByTitleJob(titleJob);
    }

    @GetMapping("typeJob") // ok
    @ResponseStatus(code = HttpStatus.OK)
    public List<JobResponseDTO> getJobsByTypeJob(@RequestParam TypeJob typeJob) {
        return jobService.getJobsByTypeJob(typeJob);
    }

    // Posts

    @PostMapping //ok
    @ResponseStatus(code=HttpStatus.CREATED)
    public JobResponseDTO createJob(@RequestBody @Valid JobRequestDTO jobRequestDTO, @RequestHeader("Authorization") String header) {
        return jobService.createJob(jobRequestDTO, header);
    }

    @PostMapping("{id}/interest")
    @ResponseStatus(code = HttpStatus.OK)
    public JobResponseInterestedUsersDTO realizeInterest(@PathVariable long id,  @RequestHeader("Authorization") String header) {
        return jobService.realizeInterest(id, header);
    }

    // Puts
    @PutMapping("{id}/change") // ok
    @ResponseStatus(code=HttpStatus.OK)
    public JobResponseDTO changeInfoJob(@PathVariable long id, @RequestBody @Valid JobRequestDTO jobRequestDTO, @RequestHeader("Authorization") String header) {
        return jobService.changeInfoJob(id, jobRequestDTO, header);
    }

    // Patches
    @PatchMapping("{id}/title") // ok
    @ResponseStatus(code=HttpStatus.OK)
    public JobResponseDTO changeTitleJob(@PathVariable long id, @RequestBody @Valid JobTitleRequestDTO jobTitleRequestDTO, @RequestHeader("Authorization") String header) {
        return jobService.changeTitleJob(id, jobTitleRequestDTO, header);
    }


    // Deletes
    @DeleteMapping("{id}/delete") // ok
    @ResponseStatus(code = HttpStatus.OK)
    public JobResponseDTO deleteJob(@PathVariable long id, @RequestHeader("Authorization") String header) {
        return jobService.deleteJob(id, header);
    }




}
