// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.TankDrive;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import frc.robot.components.hardware.OutputSetterComponent;


public class TankDrive extends SubsystemBase {
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

	public void move(double x, double y, double w) {
		ChassisSpeeds speeds = new ChassisSpeeds(x, y, w);
		DifferentialDriveWheelSpeeds speedsTwo = driveKinematic.toWheelSpeeds(speeds);
		speedsTwo.normalize(maxWheelSpeed);
		doubleLeft.setOutput(speedsTwo.leftMetersPerSecond);
		doubleRight.setOutput(speedsTwo.rightMetersPerSecond);
	}

	@Override
	public void periodic() {
    	// This method will be called once per scheduler run
	}

}
