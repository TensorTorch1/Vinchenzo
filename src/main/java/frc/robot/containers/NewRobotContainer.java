package frc.robot.containers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.components.hardware.DoubleOutputSetterComponent;
import frc.robot.components.hardware.VictorSPComponent;
import frc.robot.subsystems.TankDrive.TankDrive;
import frc.robot.subsystems.TankDrive.TankDriveFactory;
import frc.robot.subsystems.TankDrive.TankDriveCommand;
import frc.robot.subsystems.shooter.Shooter;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.shooter.ShooterSpinUpCommand;
import frc.robot.subsystems.shooter.ShooterControl;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter.ShooterSpinDownCommand;
import frc.robot.subsystems.shooter.ShooterSpinDownCommand;

public class NewRobotContainer implements RobotContainer {
    private Joystick driveStick = new Joystick(0);
    private TankDrive tankDrive = TankDriveFactory.makeTankDrive();
    private double xSensitivity = -1, ySensitivity = 1, zSensitivity = 4, xDeadzone = 0.2, yDeadzone = 0.2, zDeadzone = 0.3;
    private Shooter shooter;
    private ShooterControl shooterControl;
    private JoystickButton shooterButton = new JoystickButton(driveStick, 2);
    public NewRobotContainer() { 
        
        configureTankDrive();

    }

    public void configureTankDrive() {
        TankDriveCommand tankCommand = new TankDriveCommand(tankDrive, driveStick, xDeadzone, xSensitivity);
        tankDrive.setDefaultCommand(tankCommand);
        
    }

    public void configureShooter() {
        shooterButton.whenPressed(new ShooterSpinUpCommand(shooter, shooterControl));
        ShooterSpinDownCommand sd =new ShooterSpinDownCommand(shooter);
        shooterButton.whenReleased(sd);
    }
}
