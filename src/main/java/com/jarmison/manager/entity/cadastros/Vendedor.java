/*
* The MIT License
* 
* Copyright: Copyright (C) 2014 T2Ti.COM
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
* 
* The author may be contacted at: t2ti.com@gmail.com
*
* @author Claudio de Barros (T2Ti.com)
* @version 2.0
*/
package com.jarmison.manager.entity.cadastros;

import com.jarmison.manager.entity.comissao.ComissaoPerfil;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "VENDEDOR")
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "COMISSAO")
    private BigDecimal comissao;
    @Column(name = "META_VENDAS")
    private BigDecimal metaVendas;
    @Column(name = "GERENTE")
    private String gerente;
    @Column(name = "TAXA_GERENTE")
    private BigDecimal taxaGerente;
    @JoinColumn(name = "ID_COLABORADOR", referencedColumnName = "ID")
    @ManyToOne
    private Colaborador colaborador;
    @JoinColumn(name = "ID_COMISSAO_PERFIL", referencedColumnName = "ID")
    @ManyToOne
    private ComissaoPerfil comissaoPerfil;

    public Vendedor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public BigDecimal getMetaVendas() {
        return metaVendas;
    }

    public void setMetaVendas(BigDecimal metaVendas) {
        this.metaVendas = metaVendas;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public BigDecimal getTaxaGerente() {
        return taxaGerente;
    }

    public void setTaxaGerente(BigDecimal taxaGerente) {
        this.taxaGerente = taxaGerente;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public ComissaoPerfil getComissaoPerfil() {
        return comissaoPerfil;
    }

    public void setComissaoPerfil(ComissaoPerfil comissaoPerfil) {
        this.comissaoPerfil = comissaoPerfil;
    }

    @Override
    public String toString() {
        return "com.t2tierp.model.bean.cadastros.Vendedor[id=" + id + "]";
    }

}
