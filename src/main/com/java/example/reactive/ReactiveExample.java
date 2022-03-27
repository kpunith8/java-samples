package main.com.java.example.reactive;

import java.util.List;

import main.com.java.example.model.People;
import main.com.java.example.model.Person;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * <p>
 * Reactive examples using RxJava
 * </p>
 * 
 * @author Punith K
 */
public class ReactiveExample {
	public static void main(String[] args) {
		// ReactiveExample ex = new ReactiveExample();
		// ex.hello("Punith", "Sahana");

		Observable<Person> observable = new ReactiveExample().getData(People.createPeople());
		observable.subscribe(System.out::println, throwable -> System.out.println("Exception: " + throwable),
				() -> System.out.println("Completed"));

	}

	public void hello(String... args) {
		Flowable.fromArray(args).subscribe(System.out::println);
	}

	Observable<Person> getData(final List<Person> users) {
		return Observable.create(subscriber -> {
			if (!subscriber.isDisposed()) {
				users.stream().forEach(user -> {
					subscriber.onNext(user);
					sleep(1000);
				});
			}
			subscriber.onComplete();
		});
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}