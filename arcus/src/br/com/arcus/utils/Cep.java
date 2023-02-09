package br.com.arcus.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import br.com.arcus.model.Endereco;

public class Cep {
	String logradouro = null;
	String bairro = null;
	String cidade = null;
	String uf = null;
	String ibge = null;
	String json = null;
	public void buscarCep(String cep) {
		try {
			Endereco e = new Endereco();
			URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			StringBuilder jsonSb = new StringBuilder();
			br.lines().forEach(l -> jsonSb.append(l.trim()));
			json = jsonSb.toString();
			json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");
            String array[] = new String[30];
            array = json.split("\n");
            
            logradouro = array[7];     
            e.setLogradouro(logradouro);
            bairro = array[15];
            e.setBairro(bairro);
            cidade = array[19]; 
            e.setCidade(cidade);
            uf = array[23];
            e.setUf(uf);
            ibge = array[27];
            e.setIbge(ibge);
            Singleton.getInstance().setEndereco(e);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
