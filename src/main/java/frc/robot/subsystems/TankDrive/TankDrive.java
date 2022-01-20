// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.TankDrive;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.components.OutputSetterComponent;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;


public class TankDrive extends Subsystem {
	private OutputSetterComponent doubleLeft;
	private OutputSetterComponent doubleRight;


	private DifferentialDriveKinematics driveKinematic;
	private double maxWheelSpeed = 10d;
	/** Creates a new TankDrive. */
    public TankDrive(OutputSetterComponent left, OutputSetterComponent right) {
    	this.doubleLeft = left;
    	this.doubleRight = right;
    	this.driveKinematic = new DifferentialDriveKinematics(0.8);
    }

	public void move(double x, double w) {
		ChassisSpeeds speeds = new ChassisSpeeds(x, 0, w);
		DifferentialDriveWheelSpeeds speedsTwo = driveKinematic.toWheelSpeeds(speeds);
		speedsTwo.normalize(maxWheelSpeed);
		doubleLeft.setOutput(speedsTwo.leftMetersPerSecond);
		doubleRight.setOutput(speedsTwo.rightMetersPerSecond);
	}

	@Override
	public void periodic() {
    	// This method will be called once per scheduler run
	}

	@Override
	public void initDefaultCommand() {
		//idk
	}
}
