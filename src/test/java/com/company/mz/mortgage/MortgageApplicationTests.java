package com.company.mz.mortgage;

import com.company.mz.mortgage.entity.MortgageApplication;
import com.company.mz.mortgage.entity.Resolution;
import com.company.mz.mortgage.repository.MortgageApplicationRepository;
import com.company.mz.mortgage.repository.MortgageManualRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static com.company.mz.mortgage.entity.Resolution.TERRORIST;

@SpringBootTest
class MortgageApplicationTests {
	@Autowired
	private MortgageApplicationRepository repository;
	@Autowired
	private MortgageManualRepository manualRepository;

	@BeforeEach
	public void setUp(){
		repository.deleteAll();
		List<MortgageApplication> applicationList = Arrays.asList(
				new MortgageApplication("Ivanov Petr", Resolution.SUCCESSFUL),
				new MortgageApplication("Curpatova Helen", Resolution.SUCCESSFUL),
				new MortgageApplication("Monika Vang", Resolution.SUCCESSFUL),
				new MortgageApplication("Emily Brent", Resolution.SUCCESSFUL),
				new MortgageApplication("Professor Moriarty", TERRORIST)
		);
		repository.saveAll(applicationList);
	}

	@Test
	void contextLoads() {
		List<MortgageApplication> al = manualRepository.getAllSuccessful();
		Assertions.assertThat(al.size()==5);
	}

	@Test
	void checkStatus() {
		List<MortgageApplication> al = repository.getAllByResolutionEquals(TERRORIST);
		Assertions.assertThat(al.size() == 1);
	}

}
