package com.br.Pokando.model.heranca;





import com.br.Pokando.model.UserAcesso;

import java.io.Serializable;
import java.util.Date;

public interface IBaseClass extends Serializable {

    public Long getId();

    public void setId(Long id);

    public String getNome();

    public void setNome(String nome);

    public String getNickname();

    public void setNickname(String nickname);

    public String getEmail();

    public void setEmail(String email);

    public String getSenha();

    public void setSenha(String senha);

    public UserAcesso getUserAcesso();

    public void setUserAcesso(UserAcesso userAcesso);

    public Date getDataNascimento();

    public void setDataNascimento(Date dataNascimento);

    public String getFoto();

    public void setFoto(String foto);
}
