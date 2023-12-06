package beans.helper;

import beans.model.Colonia;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@RequestScoped
@Named
public class ColoniaHelper {

    public List<Colonia> getColonias() {
        List<Colonia> colonias = new ArrayList<>();

        int coloniaId = 1;
        Colonia colonia = new Colonia(coloniaId++, "Formosa", 3600);
        colonias.add(colonia);

        colonia = new Colonia(coloniaId++, "Corrientes", 3366);
        colonias.add(colonia);

        colonia = new Colonia(coloniaId++, "Chaco", 3112);
        colonias.add(colonia);

        return colonias;
    }

    public int getColoniaIdPorNombre(String nombreColonia) {

        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();

        for (Colonia colonia : colonias) {
            if (colonia.getNombreColonia().equals(nombreColonia)) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }

    public int getColoniaIdPorCodigoPostal(int codigoPostal) {

        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();
        for (Colonia colonia : colonias) {
            if (colonia.getCodigoPostal() == codigoPostal) {

                coloniaId = colonia.getCodigoPostal();
                break;
            }
        }

        return coloniaId;
    }

    public List<SelectItem> getSelectItems() {
        List<SelectItem> selectItems = new ArrayList<>();
        List<Colonia> colonias = this.getColonias();
        for (Colonia colonia : colonias) {
            SelectItem selectItem = new SelectItem(colonia.getColoniaId(), colonia.getNombreColonia());
            selectItems.add(selectItem);
        }
        return selectItems;
    }

}
