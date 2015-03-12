package hashcode;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
	
	private AtomicInteger generator;
	
	public IdGenerator() {
		generator = new AtomicInteger();
	}
	
	public int getNextId() {
		return generator.getAndIncrement();
	}

}
