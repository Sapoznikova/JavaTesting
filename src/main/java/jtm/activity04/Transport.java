package jtm.activity04;

import java.util.Locale;

public class Transport {
	// Do not change access modifiers to encapsulate internal properties!
	private String id; // Transport registration number
	private float consumption; // fuel consumption in litres per 100km
	private int tankSize; // tank size in litres
	private float fuelInTank; // fuel in tank

/*- TODO #1
 * Select menu Source — Generate Constructor using Fields...
 * and create constructor which sets id, consumption, tankSize
 * values of the newly created object
 * And make fuel tank full.
 */

//start

	public Transport(String id, float consumption, int tankSize) {
		this.id = id;
		this.consumption = consumption;
		this.tankSize = tankSize;
		this.fuelInTank = (float)tankSize;

	}
//end

/*- TODO #2
 * Select menu: Source — Generate getters and Setters...
 * and generate public getters for consumption, tankSize, id, and
 * fuelInTank fields
 */

//start

	public String getId() {
		return id;
	}

	public float getConsumption() {
		return consumption;
	}

	public int getTankSize() {
		return tankSize;
	}

	public float getFuelInTank() {
		return fuelInTank;
	}
//end

	/*- TODO #3
	 * Select menu: Source — Generate toString()...
	 * and implement this method, that t returns String in form:
	 * "Id:ID cons:0.0l/100km, tank:00l, fuel:00.00l"
	 * HINT: use String.format(Locale.US, "%.2f", float) to limit shown numbers
	 *  to 2 decimal for fractions, and dot as a decimal delimiter.
	 */

	@Override
	public String toString() {
//start

		String line="Id:" + id + " cons:" +consumption+ "l/100km, tank:"+tankSize +
				"l, fuel:"+String.format(Locale.US,"%.2f",fuelInTank)+"l";
		return line;
	}
//end

//Return transport id and type as string e.g. "AAA Transport"
// HINT: use this.getClass().getSimpleName(); to get type of transport

	//start
	protected final String getType() {
// TODO return required value

		String back = id+" "+this.getClass().getSimpleName();
		return back;
//end
	}

// HINT: use getType() to describe transport and road.toString() to describe
// road
// HINT: String.format(Locale.US, "%.2f", float) to format float number with
// fixed mask

	public String move(Road road) {
// TODO If transport has enough fuel, decrease actual amount of fuel by
// necessary amount and return String in form:
// "AAA Type is moving on From–To, 180km"

//start
		int distance = road.getDistance();
		String from = road.getFrom();
		String to  = road.getTo();
		String back;
		float neccesaryFuel = (((float)distance)/100)*consumption;
//end

// TODO If there is no enough fuel in tank, return string in form:
// "Cannot move on From–To, 180km. Necessary
// fuel:0.00l, fuel in tank:0.00l"

//start
		if (neccesaryFuel<fuelInTank) {
			fuelInTank=fuelInTank-neccesaryFuel;
			back = id+" Transport is moving on "+from+" — "+to+", "+distance+"km";} else
		{
			back = "Cannot move on "+from+" — "+to+", "+distance+"km. Necessary fuel:"
					+String.format(Locale.US, "%.2f", neccesaryFuel)+"l, fuel in tank:"+
					String.format(Locale.US, "%.2f", fuelInTank)+"l";
		}
		return back;
	}
//end
}