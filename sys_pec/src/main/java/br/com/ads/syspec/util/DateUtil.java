package br.com.ads.syspec.util;

import java.util.Date;

public class DateUtil {

	public static Interval interval(Date date01, Date date02){
		return new Interval(date01, date02);
	}

	public static class Interval{
		private Date date01;
		private Date date02;

		public Interval(Date date01, Date date02){
			this.date01 = date01;
			this.date02 = date02;
		}

		public double milisegundos(){
			return (double) date01.getTime() - date02.getTime();
		}
		
		public double segundos(){
			return milisegundos() / (double) 1000;
		}
		
		public double minutos(){
			return segundos() / (double) 60;
		}
		
		public double horas(){
			return minutos() / (double) 60;
		}
		
		public double dias(){
			return horas() / (double) 24;
		}
		
		public Date pontoMedio(){
			Date dt = new Date();
			dt.setTime((date01.getTime() + date02.getTime()) / 2);
			return dt;
		}
	}


	public static Date somarDias(Number n, Date data){
		return somarHoras((double) n * (double) 24, data);
	}
	public static Date somarHoras(Number n, Date data){
		return somarMinutos((double) n * (double) 60, data);
	}
	public static Date somarMinutos(Number n, Date data){
		return somarSegundos((double) n * (double) 60, data);
	}
	public static Date somarSegundos(Number n, Date data){
		return somarMilisegundos((double) n * (double) 1000, data);
	}
	public static Date somarMilisegundos(Number n, Date data){
		Date dt = new Date();
		dt.setTime(data.getTime() + n.longValue());
		return dt;
	}
	
	public static Date subtrairDias(Number n, Date data){
		return subtrairHoras((double) n * (double) 24, data);
	}
	public static Date subtrairHoras(Number n, Date data){
		return subtrairMinutos((double) n * (double) 60, data);
	}
	public static Date subtrairMinutos(Number n, Date data){
		return subtrairSegundos((double) n * (double) 60, data);
	}
	public static Date subtrairSegundos(Number n, Date data){
		return subtrairMilisegundos((double) n * (double) 1000, data);
	}
	public static Date subtrairMilisegundos(Number n, Date data){
		Date dt = new Date();
		dt.setTime(data.getTime() - n.longValue());
		return dt;
	}
}
