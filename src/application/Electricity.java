package application;

import java.util.Date;

public class Electricity implements Comparable<Electricity> {

	private int daye;
	private int month;
	private int year;
	private int Israeli_Lines_MWs;
	private int Gaza_Power_Plant_MWs;
	private int Egyptian_Lines_MWs;
	private int Total_daily_Supply_available_in_MWs;
	private int Overall_demand_in_MWs;
	private int Power_Cuts_hours_day_400mg;
	private int Temp;

	public Electricity(int daye, int israeli_Lines_MWs, int gaza_Power_Plant_MWs, int egyptian_Lines_MWs,
			int total_daily_Supply_available_in_MWs, int overall_demand_in_MWs, int power_Cuts_hours_day_400mg,
			int temp) {

		this.daye = daye;
		Israeli_Lines_MWs = israeli_Lines_MWs;
		Gaza_Power_Plant_MWs = gaza_Power_Plant_MWs;
		Egyptian_Lines_MWs = egyptian_Lines_MWs;
		Total_daily_Supply_available_in_MWs = total_daily_Supply_available_in_MWs;
		Overall_demand_in_MWs = overall_demand_in_MWs;
		Power_Cuts_hours_day_400mg = power_Cuts_hours_day_400mg;
		Temp = temp;
	}

	public Electricity(int month, int year) {
		this.month = month;
		this.year = year;
	}

	public int getDaye() {
		return daye;
	}

	public void setDaye(int daye) {
		this.daye = daye;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getIsraeli_Lines_MWs() {
		return Israeli_Lines_MWs;
	}

	public void setIsraeli_Lines_MWs(int israeli_Lines_MWs) {
		Israeli_Lines_MWs = israeli_Lines_MWs;
	}

	public int getGaza_Power_Plant_MWs() {
		return Gaza_Power_Plant_MWs;
	}

	public void setGaza_Power_Plant_MWs(int gaza_Power_Plant_MWs) {
		Gaza_Power_Plant_MWs = gaza_Power_Plant_MWs;
	}

	public int getEgyptian_Lines_MWs() {
		return Egyptian_Lines_MWs;
	}

	public void setEgyptian_Lines_MWs(int egyptian_Lines_MWs) {
		Egyptian_Lines_MWs = egyptian_Lines_MWs;
	}

	public int getTotal_daily_Supply_available_in_MWs() {
		return Total_daily_Supply_available_in_MWs;
	}

	public void setTotal_daily_Supply_available_in_MWs(int total_daily_Supply_available_in_MWs) {
		Total_daily_Supply_available_in_MWs = total_daily_Supply_available_in_MWs;
	}

	public int getOverall_demand_in_MWs() {
		return Overall_demand_in_MWs;
	}

	public void setOverall_demand_in_MWs(int overall_demand_in_MWs) {
		Overall_demand_in_MWs = overall_demand_in_MWs;
	}

	public int getPower_Cuts_hours_day_400mg() {
		return Power_Cuts_hours_day_400mg;
	}

	public void setPower_Cuts_hours_day_400mg(int power_Cuts_hours_day_400mg) {
		Power_Cuts_hours_day_400mg = power_Cuts_hours_day_400mg;
	}

	public int getTemp() {
		return Temp;
	}

	public void setTemp(int temp) {
		Temp = temp;
	}
	
	@Override
	public String toString() {
		return "daye=" + daye + ", Israeli_Lines_MWs=" + Israeli_Lines_MWs + ", Gaza_Power_Plant_MWs="
				+ Gaza_Power_Plant_MWs + ", Egyptian_Lines_MWs=" + Egyptian_Lines_MWs
				+ ", Total_daily_Supply_available_in_MWs=" + Total_daily_Supply_available_in_MWs
				+ ", Overall_demand_in_MWs=" + Overall_demand_in_MWs + ", Power_Cuts_hours_day_400mg="
				+ Power_Cuts_hours_day_400mg + ", Temp=" + Temp + "";
	}

	@Override
	public int compareTo(Electricity o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
