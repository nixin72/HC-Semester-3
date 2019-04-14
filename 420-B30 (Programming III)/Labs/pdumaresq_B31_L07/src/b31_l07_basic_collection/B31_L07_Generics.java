package b31_l07_basic_collection;

import java.util.Collection;
import inheritance.Animal;

public class B31_L07_Generics {
	public B31_L07_Generics() {
	} // B31_L07_Generics()

	public void whatAreYou(Collection<Object> coll) {
		for (Object q : coll) {
			System.out.println(q.getClass());
		}
	}

	public void showMe(Collection<?> coll) {
		for (Object q : coll) {
			System.out.println(q.getClass());
		}
	}
	
	public void talkNow(Collection<Animal> coll) {
		for (Animal q : coll) {
			q.speak();
		}
	}
	
	public void everybodySpeak(Collection<? extends Animal> coll) {
		for (Animal q : coll) {
			q.speak();
		}
	}
	
	public <E> void whoAreYou(Collection<E> coll) {
		for (E q : coll) {
			((Animal) q).speak();
		}
	}
	
} // B31_L07_Generics
