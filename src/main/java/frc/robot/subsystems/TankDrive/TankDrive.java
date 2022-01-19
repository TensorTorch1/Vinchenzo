// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.command.SubsystemBase;

import frc.robot.components.OutputSetterComponent;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;

public class TankDrive extends SubsystemBase {
	private OutputSetterComponent left;
	private OutputSetterComponent right;
	private DifferentialDriveKinematics driveKinematic;
	private double maxWheelSpeed = 10d;
	/** Creates a new TankDrive. */
    public TankDrive(OutputSetterComponent left, OutputSetterComponent right) {
    	this.left = left;
    	this.right = right;
    	this.driveKinematic = new DifferentialDriveKinematics(0.8);
    }

	public void move(double x, double w) {
		ChassisSpeeds speeds = new ChassisSpeeds(x, 0, w);
		DifferentialDriveWheelSpeeds speedsTwo = driveKinematic.toWheelSpeeds(speeds);
		speedsTwo.desaturate(maxWheelSpeed);
		left.setOutput(speedsTwo.leftMetersPerSecond);
		right.setOutput(speedsTwo.rightMetersPerSecond);
	}

	@Override
	public void periodic() {
    	// This method will be called once per scheduler run
	}
}
