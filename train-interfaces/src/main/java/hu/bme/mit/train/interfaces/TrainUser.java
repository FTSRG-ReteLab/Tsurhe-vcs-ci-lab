package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	void setAlarm(boolean alarm);

	boolean getAlarm();

	boolean getAlarmFlag();

	void overrideJoystickPosition(int joystickPosition);

}
