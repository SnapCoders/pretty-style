function limpa_formulário_cep() {
  //Limpa valores do formulário de cep.
  document.getElementById('place').value=('');
  document.getElementById('neighborhood').value=('');
  document.getElementById('city').value=('');
  document.getElementById('state').value=('');
  document.getElementById('country').value=('');
}

function meu_callback(conteudo) {
  if (!('erro' in conteudo)) {
    //Atualiza os campos com os valores.
    document.getElementById('place').value=(conteudo.logradouro);
    document.getElementById('neighborhood').value=(conteudo.bairro);
    document.getElementById('city').value=(conteudo.localidade);
    document.getElementById('state').value=(conteudo.uf);
    document.getElementById('country').value=("Brasil");
  } //end if.
  else {
    //CEP não Encontrado.
    limpa_formulário_cep();
    alert('CEP não encontrado.');
  }
}
        
function pesquisacep(valor) {

  //Nova variável 'cep' somente com dígitos.
  var cep = valor.replace(/\D/g, '');

  //Verifica se campo cep possui valor informado.
  if (cep != '') {

    //Expressão regular para validar o CEP.
    var validacep = /^[0-9]{8}$/;

    //Valida o formato do CEP.
    if(validacep.test(cep)) {

      //Preenche os campos com '...' enquanto consulta webservice.
      document.getElementById('place').value='...';
      document.getElementById('neighborhood').value='...';
      document.getElementById('city').value='...';
      document.getElementById('state').value='...';
      document.getElementById('country').value='...';

      //Cria um elemento javascript.
      var script = document.createElement('script');

      //Sincroniza com o callback.
      script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

      //Insere script no documento e carrega o conteúdo.
      document.body.appendChild(script);

    } //end if.
    else {
      //cep é inválido.
      limpa_formulário_cep();
      alert('Formato de CEP inválido.');
    }
  } //end if.
  else {
    //cep sem valor, limpa formulário.
    limpa_formulário_cep();
  }
};