
package otavioprocopiorosa.p2ads;


public class Consulta {
    
    private String nome;
    private int convenio;
    private double valorBase;

    public Consulta() {
    }

    public Consulta(String nome, int convenio, double valorBase) {
        this.nome = nome;
        this.convenio = convenio;
        this.valorBase = valorBase;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getConvenio() {
        return convenio;
    }

    public void setConvenio(int convenio) {
        this.convenio = convenio;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
    
    public double valorConsultaPorConvenio(int convenio){
        double valorConsulta = 0;
        if(convenio == 1){
            valorConsulta = valorBase;
        }else if(convenio == 2 ){
            valorConsulta = valorBase*0.5;
        }else if (convenio == 3){
            valorConsulta = valorBase*0.3;
        }
        return valorConsulta;
    }
    
    @Override
    public String toString(){
        return String.format("%10s %10d %10.2f", nome, convenio,
	                valorBase);
      
    }
    
}
