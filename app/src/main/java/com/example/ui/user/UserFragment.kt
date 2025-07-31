package com.example.ui.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.study2.databinding.FragmentUserBinding
import com.example.ui.utils.Constants.APP_TAG

class UserFragment : Fragment() {

    private val viewModel: UserViewModel by viewModels()
    private lateinit var binding: FragmentUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(APP_TAG, "onCreate aqui")
        super.onCreate(savedInstanceState)

        // Este método é chamado quando a Fragment está sendo criada.
        // Ele é chamado antes do onCreateView.
        // Aqui você pode inicializar a ViewModel, configurar o estado da Fragment, ou realizar outras operações que não dependem da UI.
        // Se savedInstanceState não for nulo, significa que a Fragment está sendo recriada após uma configuração de tela (por exemplo, rotação), e você pode usar os dados salvos para restaurar o estado.
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i(APP_TAG, "onCreateView aqui")
        // Este método é chamado quando a Fragment precisa criar ou retornar seu layout.
        // Aqui você deve inflar o layout da Fragment e retornar a View que representa o layout da UI.
        // Se você não retornar uma View, a Fragment não terá um layout visível.
        // O parâmetro 'inflater' é usado para inflar o layout XML em uma View.
        // O parâmetro 'container' é o ViewGroup no qual a View da Fragment será adicionada.
        // O parâmetro 'savedInstanceState' pode ser usado para restaurar o estado da UI se a Fragment estiver sendo recriada.
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(APP_TAG, "onViewCreated aqui")
        super.onViewCreated(view, savedInstanceState)
        configureButtons()
        configureObservers()
        loadSharedPreferencesData()
        // Este método é chamado após o layout da Fragment ter sido inflado e antes dele ser adicionado à hierarquia da UI.
        // Aqui você pode inicializar componentes da UI, como TextView, Button, etc., e configurar listeners ou interações com a UI.
        // Se savedInstanceState não for nulo, você pode usar para restaurar o estado da UI.
    }

    private fun configureButtons() = with(binding) {
        buttonSaveName.setOnClickListener {
            Log.i(APP_TAG, "clcik no botão de alterar nome")
            viewModel.addUserName(editNewName.text.toString())
        }
    }

    private fun configureObservers() = with(binding) {
        //observando sempre que tem mudança no username
        //viewModel.username.observe(viewLifecycleOwner) { username ->
        //    Log.i(APP_TAG, "Obsrvando o username para mudança")
        //    txtviewYourName.text = username
        //}
        //observando se o nome valido
        //viewModel.isUsernameValid.observe(viewLifecycleOwner) { isUsernameValid ->
        //    Log.i(APP_TAG, "Obsrvando o username para validação")
        //    if (isUsernameValid) {
        //        Toast.makeText(context, "Nome válido", Toast.LENGTH_SHORT).show()
        //        viewModel.setUsername(editNewName.text.toString())
        //    } else {
        //        Toast.makeText(context, "Nome inválido", Toast.LENGTH_SHORT).show()
        //    }
        //}
    }

    private fun loadSharedPreferencesData() {
        viewModel.loadAllUserNames()
    }

    override fun onStart() {
        Log.i(APP_TAG, "onStart aqui")
        super.onStart()
        // Este método é chamado quando a Fragment está se tornando visível para o usuário, mas ainda não está interativa.
        // Aqui você pode iniciar operações que dependem da visibilidade da Fragment, como iniciar animações ou preparar dados para serem mostrados na UI.
    }

    override fun onResume() {
        Log.i(APP_TAG, "onResume aqui")
        super.onResume()
        // Este método é chamado quando a Fragment está completamente visível e interativa.
        // Aqui você pode iniciar operações que dependem da interação do usuário, como iniciar um serviço de reprodução de mídia ou configurar listeners de eventos de toque.
    }

    override fun onPause() {
        Log.i(APP_TAG, "onPause aqui")
        super.onPause()
        // Este método é chamado quando a Fragment está se tornando não interativa, geralmente porque outra Activity ou Fragment está cobrindo a tela.
        // Aqui você deve salvar o estado da UI e liberar recursos que não são necessários enquanto a Fragment não está interativa, como parar animações ou serviços de reprodução de mídia.
    }

    override fun onStop() {
        Log.i(APP_TAG, "onStop aqui")
        super.onStop()
        viewModel.saveAllUserNames()
        // Este método é chamado quando a Fragment não está mais visível para o usuário.
        // Aqui você deve liberar recursos que não são necessários enquanto a Fragment não está visível, como cancelar requisições de rede ou limpar dados da UI.
    }

    override fun onDestroy() {
        Log.i(APP_TAG, "onDestroy aqui")
        super.onDestroy()
        // Este método é chamado quando a Fragment está sendo destruída.
        // Aqui você deve liberar todos os recursos restantes, como cancelar listeners ou fechar conexões de banco de dados.
        // Este é o último método chamado no ciclo de vida da Fragment.
    }
}