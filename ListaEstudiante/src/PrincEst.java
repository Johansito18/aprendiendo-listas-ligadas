import javax.swing.JOptionPane;

public class PrincEst 
{
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int opc=0,cedula, celular;
        String nombre, apellido, correo, plan_es, materia, d = "";
        Lista L1 = new Lista();
        
        
        do
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("***Menú principal***\n\n" +
                                                            "1. Insertar estudiantes\n" +
                                                            "2. buscar estudiantes por cedula\n" + 
                                                            "3. Mostrar estudiantes\n" +
                                                            "4. modificar estudiantes\n" +
                                                            "5. eliminar estudiantes\n" +
                                                            "6. control de notas\n" +
                                                            "7. reporte de notas\n" +
                                                            "8. salir\n" +
                                                            "   ****ingrese la opcion***\n\n"));
            switch (opc)
            {
                case 1:
                    cedula = Integer.parseInt(JOptionPane.showInputDialog("ingrese cedula del estudiante"));;
                    nombre = (JOptionPane.showInputDialog("Ingrese nombre del estudiante: "));;
                    apellido = (JOptionPane.showInputDialog("Ingrese apellido del estudiante: "));;
                    celular = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número telefonico del estudiante: "));;
                    correo = (JOptionPane.showInputDialog("Ingrese correo estudiante: "));;
                    plan_es = (JOptionPane.showInputDialog("Ingrese plan de estudio: "));;
                    materia = (JOptionPane.showInputDialog("Ingrese materias del estudiante: "));;
                    
                    L1.InsertarOrdenado(cedula, nombre, apellido, celular, correo, plan_es, materia);
                    
                    break;
                case 2:
                    cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del estudiante para buscar: "));
                    //L1.buscarCedula(cedula);
                    L1.buscarCedula(cedula);
                    break;
                case 3:
                    
                    d = L1.MostrarEstudiante();
                    JOptionPane.showMessageDialog(null, d, "Mostrando lista estudiantes", -1);
                    break;
                case 4:
                    cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del estudiante para buscar: "));
                    L1.ModificarEst(cedula);
                    break;
                case 5:
                    cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del estudiante a eliminar: "));
                    L1.borrarEst(cedula);
                    break;
                case 6:
                    cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del estudiante a controlar notas: "));
                    L1.controlNotas(cedula);
                    break;
                case 7:
                    cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del estudiante a reportar notas: "));
                    L1.reporteNotas(cedula);
                    break;
                case 8:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta");

            }
        } while (opc != 8);

    }
}
