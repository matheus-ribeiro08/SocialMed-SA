package org.example.view.medico;

import org.example.utils.Ferramentas;
import org.example.viewInterface.viewInterfaceMedico.IMedicoView;

public class MedicoView implements IMedicoView {

    @Override
    public int mostrarMenuMedico() {



        try{
            return Integer.parseInt(Ferramentas.lString());
        }
        catch (NumberFormatException e)
        {
            return -1;
        }



    }
}
