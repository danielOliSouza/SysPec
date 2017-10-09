package br.com.ads.syspec.util;

import java.util.Date;

public class DateUtil {

	public static Interval interval(Date date01, Date date02){
		return new Interval(date01, date02);
	}

	public static Match match(Date dt){
		return new Match(dt);
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

	public static class Match{
		Date dt;
		public Match(Date dt){
			this.dt = dt;
		}
		
		public Date somarDias(Number n){
			return somarHoras((double) n / (double) 24);
		}
		
		public Date somarHoras(Number n){
			return somarMinutos((double) n / (double) 60);
		}
		
		public Date somarMinutos(Number n){
			return somarSegundos((double) n / (double) 60);
		}
		
		public Date somarSegundos(Number n){
			return somarMilisegundos((double) n / (double) 1000);
		}
		
		public Date somarMilisegundos(Number n){
			
			dt.setTime(dt.getTime() + (long)n.longValue());
			return dt;
		}
		
		
		public Date subtrairDias(Number n){
			return subtrairHoras((double) n / (double) 24);
		}
		
		public Date subtrairHoras(Number n){
			return subtrairMinutos((double) n / (double) 60);
		}
		
		public Date subtrairMinutos(Number n){
			return subtrairSegundos((double) n / (double) 60);
		}
		
		public Date subtrairSegundos(Number n){
			return subtrairMilisegundos((double) n / (double) 1000);
		}
		
		public Date subtrairMilisegundos(Number n){
			dt.setTime(dt.getTime() - (long)n.longValue());
			return dt;
		}
	}
}
