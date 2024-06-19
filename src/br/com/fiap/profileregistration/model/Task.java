package br.com.fiap.profileregistration.model;

public class Task {
	
	private double task = 3;
	private double completedTask = 1;
	private double progress;
	

	public double getTask() {
		return task;
	}


	public void setTask(double task) {
		this.task = task;
	}


	public double getCompletedTask() {
		return completedTask;
	}


	public void setCompletedTask(double completedTask) {
		this.completedTask = completedTask;
	}


	public double getProgress() {
		return progress;
	}

	public void setProgress(double progress) {
		this.progress = progress;
	}
	
	public void showProgress() {
		System.out.println("Seu progresso está em: " + getProgress() + "%");
	}
	public void calculateProgress() {
		setProgress((getCompletedTask() / getTask()) * 100);
	}
}
