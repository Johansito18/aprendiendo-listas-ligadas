import javax.swing.JOptionPane;

public class Lista {
    NodoEst punta;

    public Lista() {
        punta = null; // al iniciar la lista no tiene nada, por eso está en null
    }

    public void InsertarOrdenado(int cedula, String nombre, String apellido,
            int celular, String correo, String plan_es, String materia) {
        // Instancia
        NodoEst estudiante = new NodoEst(cedula, nombre, apellido, celular,
                correo, plan_es, materia);
        for (int i = 0; i < estudiante.getNotas().length; i++) {
            estudiante.setNotas(i, Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota: ")));
        }
        NodoEst p;
        NodoEst liga = null;
        // Nodo x = new Nodo();
        // estudiante.setCedula(cedula);

        if (punta == null) {
            punta = estudiante;
        } else {
            p = punta;

            while (p != null) {

                if (estudiante.getCedula() > p.getCedula()) {
                    liga = p;
                    p = p.getLiga();
                    // avance
                } else {
                    if (liga.getLiga() == null) {
                        estudiante.setLiga(punta);
                    } else {
                        liga.setLiga(estudiante); // la liga de a apunta a x
                        estudiante.setLiga(p); // la liga de x apunta a p
                    }
                    p = null; // rompimiento cuando haya insertado
                }
            }
            if (liga != null && liga.getLiga() == null) {
                liga.setLiga(estudiante); // Insertar al final
            }
        }
    }

    public void buscarCedula(int cedula) {

        NodoEst p = punta;

        while (p != null && p.getCedula() != cedula) {

            p = p.getLiga();
        }
        if (p != null) {
            JOptionPane.showMessageDialog(null, "estudiante " + cedula + " se encuentra matriculado");
        } else {
            JOptionPane.showMessageDialog(null, "estudiante no se encuentra matriculado");

        }
    }

    public String MostrarEstudiante() {
        NodoEst p = punta;
        String d = "";
        int i = 0;
        String not = "";

        while (p != null) // hasta que p finalice
        {
            // System.out.print("|"+p.getDato()+"|"+p.getLiga()+"|-->");
            for (i = 0; i < p.getNotas().length; i++) {
                not = not + "\n" + "[" + p.getNotas(i) + "]";
            }

            d = d + "-->" + "\n" + "|" + p.getCedula() + "|" + p.getNombre() + "|" + p.getApellido() + "|"
                    + p.getCelular() + "|" + p.getCorreo() +
                    "|" + p.getPlan_es() + not + "\n" + "-->";

            p = p.getLiga(); // Avanzar, apunta al siguiente
            not = ""; // reiniciar las notas
        }

        return d;
    }

    public void ModificarEst(int cedula) {
        int opc2 = 0;
        NodoEst p;

        int celular;
        String nombre, apellido, correo, plan_es, materia;

        if (punta == null) {
            JOptionPane.showMessageDialog(null, "La lista no existe");
        } else {
            p = punta;
            while (p != null) {
                if (p.getCedula() == cedula) {
                    do {
                        opc2 = Integer.parseInt(JOptionPane.showInputDialog("***Modificar***\n\n" +
                                "1. Modificar cedula\n" +
                                "2. Modificar nombre\n" +
                                "3. Modificar apellido\n" +
                                "4. Modificar celular\n" +
                                "5. Modificar correo\n" +
                                "6. Modificar planEstudio\n" +
                                "7. Modificar materia\n" +
                                "8. salir\n" +
                                "****ingrese la opcion***\n\n"));
                        switch (opc2) {
                            case 1:
                                cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva cedula: "));
                                p.setCedula(cedula);
                                break;
                            case 2:
                                nombre = JOptionPane.showInputDialog("Ingrese nuevo nombre: ");
                                p.setNombre(nombre);
                                break;
                            case 3:
                                apellido = JOptionPane.showInputDialog("Ingrese nuevo apellido: ");
                                p.setApellido(apellido);
                                break;
                            case 4:
                                celular = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo celular: "));
                                p.setCelular(celular);
                                break;
                            case 5:
                                correo = JOptionPane.showInputDialog("Ingrese nueva cedula: ");
                                p.setCorreo(correo);
                                break;
                            case 6:
                                plan_es = JOptionPane.showInputDialog("Ingrese nuevo plan de estudios: ");
                                p.setPlan_es(plan_es);
                                break;
                            case 7:
                                materia = JOptionPane.showInputDialog("Ingrese nueva materia: ");
                                p.setMateria(materia);
                                break;
                            case 8:
                                break;
                        }
                    } while (opc2 != 8);

                }
                p = p.getLiga();
            }
        }
    }

    public void borrarEst(int cedula) {
        NodoEst p, n = null;
        ;

        if (punta == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacia");
        } else {
            p = punta;
            while (p != null && p.getCedula() != cedula) {
                n = p;
                p = p.getLiga();
            }

            if (p != null) {
                if (p == punta) {
                    punta = punta.getLiga();
                    p.setLiga(null);
                } else {
                    n.setLiga(p.getLiga());
                    p.setLiga(null);
                }
                JOptionPane.showMessageDialog(null, "El estudiante con cedula " + cedula + " ha sido eliminado");

            } else {
                JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
            }

        }

    }

    public void controlNotas(int cedula) {
        int opc3 = 0;
        NodoEst p;
        p = punta;
        String nott = "";
        if(p == null)
        {
            JOptionPane.showMessageDialog(null, "La lista está vacia"); 
        }
        else
        {
            while (p != null)
            {
                if (p.getCedula() == cedula)
                {
    
                    do {
                        opc3 = Integer.parseInt(JOptionPane.showInputDialog("***Modificar Notas***\n\n" +
                                "1. Modificar nota 1\n" +
                                "2. Modificar nota 2\n" +
                                "3. Modificar nota 3\n" +
                                "4. Modificar nota 4\n" +
                                "5. Modificar nota 5\n" +
                                "6. salir\n" +
                                "****ingrese la opcion***\n\n"));
                        switch (opc3) {
                            case 1:
                                for (int i = 0; i < p.getNotas(i); i++) {
                                    p.getNotas(i);
                                    if (p.getNotas(i) == p.getNotas(0)) {
                                        p.setNotas(0,
                                                Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota 1: ")));
                                    }
                                }
                                nott = "";
                                break;
                            case 2:
                                for (int i = 0; i < p.getNotas(i); i++) {
                                    p.getNotas(i);
                                    if (p.getNotas(i) == p.getNotas(1)) {
                                        p.setNotas(1,
                                                Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota 2: ")));
                                    }
                                }
                                nott = "";
    
                                break;
                            case 3:
                                for (int i = 0; i < p.getNotas(i); i++) {
                                    p.getNotas(i);
                                    if (p.getNotas(i) == p.getNotas(2)) {
                                        p.setNotas(2,
                                                Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota 3: ")));
                                    }
                                }
                                nott = "";
    
                                break;
                            case 4:
                                for (int i = 0; i < p.getNotas(i); i++) {
                                    p.getNotas(i);
                                    if (p.getNotas(i) == p.getNotas(3)) {
                                        p.setNotas(3,
                                                Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota 4: ")));
                                    }
                                }
                                nott = "";
    
                                break;
                            case 5:
                                for (int i = 0; i < p.getNotas(i); i++) {
                                    p.getNotas(i);
                                    if (p.getNotas(i) == p.getNotas(4)) {
                                        p.setNotas(4,
                                                Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota 5: ")));
                                    }
                                }
                                nott = "";
                                break;
                            case 6:
                                break;
                        }
                    } while (opc3 != 6);
    
                }
                p = p.getLiga();
            }
        }
    }
    public void reporteNotas(int cedula)
    {
        NodoEst p = punta;
        String b = "";
        String nottt = "";

        if (p == null)
        {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        else
        {
            while (p != null)
            {
                if (p.getCedula() == cedula)
                {
                    for (int i = 0; i < p.getNotas().length; i++)
                {
                    nottt = nottt + "\n"+"[" + p.getNotas(i) + "]" + "\n";
                }
                JOptionPane.showMessageDialog(null, "Las notas del estudiante "+cedula+" son "+nottt);

                b = b + nottt;
                p = p.getLiga();
                nottt = "";
                }
                
            }
            
        }
    }
}
