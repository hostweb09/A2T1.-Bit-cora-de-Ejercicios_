import javax.swing.*;
import java.awt.*;

public class Paneles1 extends JFrame
{	//DECLARACI�N DE MIEMBROS DE CLASE O ATRIBUTOS
	//variables con ambito de clase
	JLabel lblDiagonal, lblDiagonal2, lblNombre, lblDni, lblFecha;
	JTextField txtNombre, txtDni, txtDia, txtAnio, txtMes;
	JButton cmdAceptar, cmdCancelar;

    public Paneles1( String titulo ) 
    {	super(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(250,170);
        
        //INICIALIZAMOS LOS ATRIBUTOS
        lblDiagonal = new JLabel("/");
        lblDiagonal2 = new JLabel("/");
        lblNombre = new JLabel("Nombre:");
        lblDni = new JLabel("DNI:");
        lblFecha = new JLabel("Fecha de Nacimiento:");
        txtNombre = new JTextField(10);
        txtDni = new JTextField(10);
        txtDia = new JTextField(2);
        txtMes = new JTextField(2);
        txtAnio = new JTextField(2);
        cmdAceptar = new JButton("ACEPTAR");
        cmdCancelar = new JButton("CANCELAR");	
        	
        // Panel de fecha
        JPanel panelFecha = new JPanel();
        FlowLayout fl = new FlowLayout();//ordena de izquierda a derecha
        panelFecha.setLayout( fl );
        
        panelFecha.add( txtDia );
        panelFecha.add( lblDiagonal );
        panelFecha.add( txtMes );
        panelFecha.add( lblDiagonal2 );
        panelFecha.add( txtAnio ); 
        	       
        // Panel de datos
        JPanel panelDatos = new JPanel();
        GridLayout gl = new GridLayout(3,2,0,5);
        panelDatos.setLayout(gl); //AGREGAMOS AL PANEL DATOS EL DISE�ADOR
        
        panelDatos.add( lblNombre );
        panelDatos.add( txtNombre );
        panelDatos.add( lblDni );
        panelDatos.add( txtDni );
        panelDatos.add( lblFecha);
        panelDatos.add( panelFecha);
        
        //panel de comandos o botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add( cmdAceptar );
        panelBotones.add( cmdCancelar );
        
        Container cp = getContentPane();
        cp.add(panelDatos, BorderLayout.CENTER);
        cp.add(panelBotones, BorderLayout.SOUTH);
        
        setVisible(true);
    }//fin del constructor
    
    public static void main (String[] args) 
    {	Paneles1 ventana = new Paneles1("Mi Aplicacion");
	}
    
}//fin de la clase