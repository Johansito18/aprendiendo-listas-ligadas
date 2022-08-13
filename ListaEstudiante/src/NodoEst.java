public class NodoEst {
    private int cedula;
    private String nombre;
    private String apellido;
    private int celular;
    private String correo;
    private String plan_es;
    private String materia;
    private double notas[];
    private NodoEst liga;

    public NodoEst(int cedula, String nombre, String apellido, int celular, String correo, String plan_es,
        String materia) {
            
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
        this.plan_es = plan_es;
        this.materia = materia;
        this.notas = new double[5];
        liga = null;
    }
    

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPlan_es() {
        return plan_es;
    }

    public void setPlan_es(String plan_es) {
        this.plan_es = plan_es;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public NodoEst getLiga() {
        return liga;
    }

    public void setLiga(NodoEst liga) {
        this.liga = liga;
    }

    public double[] getNotas() {
        return notas;
    }
    public double getNotas(int i){
        return notas[i];
    }

    public void setNotas(int i, double nota) {
      notas[i] = nota;
    }
    public void setNotas(double[] notas) {
        this.notas = notas;
    }
}
