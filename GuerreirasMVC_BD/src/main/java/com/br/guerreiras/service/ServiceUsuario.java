package com.br.guerreiras.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.guerreiras.exception.CriptioExistException;
import com.br.guerreiras.exception.EmailExistsException;
import com.br.guerreiras.exception.ServiceExc;
import com.br.guerreiras.model.Usuario;
import com.br.guerreiras.repository.UsuarioRepository;
import com.br.guerreiras.util.Util;

@Service
public class ServiceUsuario {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	public void salvarUsuario(Usuario user) throws Exception {
		
		try {
			if(usuarioRepository.findByEmail(user.getEmail()) != null) {
				throw new EmailExistsException("Já exixte email cadastrado para: " + user.getEmail());
		} 
			user.setSenha(Util.md5(user.getSenha()));
			
	} catch(NoSuchAlgorithmException e){
			throw new CriptioExistException("Erro na Criptiografia da Senha");				
		}
		usuarioRepository.save(user);		
	}
	
	public Usuario loginUser(String user, String senha) throws ServiceExc {
		
		Usuario userLogin = usuarioRepository.buscarLogin(user, senha);
		return userLogin;
		
	}
}

