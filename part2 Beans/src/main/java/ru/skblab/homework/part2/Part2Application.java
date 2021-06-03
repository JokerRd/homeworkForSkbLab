package ru.skblab.homework.part2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.skblab.homework.part2.model.LiveAndDeath;
import ru.skblab.homework.part2.model.SuperClass;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication()
public class Part2Application implements CommandLineRunner {

	//через констуктор
	private final LiveAndDeath liveAndDeath;

	private final SuperClass superClassFirst;

	private final SuperClass superClassSecond;

	//через поле
	@Autowired
	private  AtomicInteger counter;

	private AtomicBoolean isParty;

	@Autowired
	public void setIsParty(AtomicBoolean isParty) {
		this.isParty = isParty;
	}

	public Part2Application(LiveAndDeath liveAndDeath, @Qualifier("first") SuperClass superClassFirst,
							@Qualifier("second") SuperClass superClassSecond) {
		this.liveAndDeath = liveAndDeath;
		this.superClassFirst = superClassFirst;
		this.superClassSecond = superClassSecond;
	}

	public static void main(String[] args) {
		SpringApplication.run(Part2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println( "How many millions in the account? - " + counter.get());
		System.out.println( "Party? - " + isParty.get());
		superClassFirst.run();
		superClassSecond.run();
	}
}
