package frc.robot.subsystems.shooter;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterSpinUpCommand extends CommandBase{
    private Shooter shooter;
    private ShooterControl shooterControl;
    private double speed;
    public ShooterSpinUpCommand(Shooter s, ShooterControl shooterControl) {
        shooter = s;
        this.shooterControl = shooterControl;
        addRequirements(s);
    }

    @Override
    public void initialize() {
        shooter.setSpeed(shooterControl.shooterSpeed);
        speed = shooterControl.shooterSpeed;
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return (Math.abs(speed - shooter.getSpeed()) < shooterControl.speedThreshold);
    }

    
}
