package hu.bme.mit.train.controller;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Date;

public class Tachograph {
	private Table<Date, Integer, Integer> mytable = HashBasedTable.create();

	public void addTableElement(Date d, Integer joystickPos, Integer referenceSpeed) {
		mytable.put(d, joystickPos, referenceSpeed);
	}

	public boolean isEmpty() {
		return mytable.isEmpty();
	}
}
