package frc.robot.containers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.components.hardware.DoubleOutputSetterComponent;
import frc.robot.components.hardware.VictorSPComponent;
import frc.robot.subsystems.TankDrive.TankDrive;
import frc.robot.subsystems.TankDrive.TankDriveFactory;
import frc.robot.subsystems.TankDrive.TankDriveCommand;

public class NewRobotContainer implements RobotContainer {
    private Joystick driveStick = new Joystick(0);
    private TankDrive tankDrive = TankDriveFactory.makeTankDrive();
    private double xSensitivity = 4, ySensitivity = 4, zSensitivity = 4, xDeadzone = 0.2, yDeadzone = 0.2, zDeadzone = 0.3;

    public NewRobotContainer() { 
        
        configureTankDrive();

    }

    public void configureTankDrive() {
        TankDriveCommand tankCommand = new TankDriveCommand(tankDrive, driveStick, xDeadzone, xSensitivity);
        tankDrive.setDefaultCommand(tankCommand);
        
    }
}
