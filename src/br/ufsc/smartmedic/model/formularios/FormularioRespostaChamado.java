package br.ufsc.smartmedic.model.formularios;

import br.ufsc.smartmedic.model.Medicamento;
import br.ufsc.smartmedic.model.PrescricaoMedicamento;
import br.ufsc.smartmedic.model.UnidadeAtendimento;

import java.util.List;

public class FormularioRespostaChamado {
    private long id;
    private String diagnostico;
    private List<PrescricaoMedicamento> prescricaoMedicamentos;
    private String frequencia;
    private boolean encaminhamento;
    private UnidadeAtendimento unidadeDeEncaminhamento;

    public FormularioRespostaChamado() {

    }

    public FormularioRespostaChamado(long id, String diagnostico, String frequencia, boolean encaminhamento, UnidadeAtendimento unidadeDeEncaminhamento) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.frequencia = frequencia;
        this.encaminhamento = encaminhamento;
        this.unidadeDeEncaminhamento = unidadeDeEncaminhamento;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setPrescricaoMedicamentos(List<PrescricaoMedicamento> prescricaoMedicamentos) {
        this.prescricaoMedicamentos = prescricaoMedicamentos;
    }
}
