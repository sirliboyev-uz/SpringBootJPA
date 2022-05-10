package com.test.springbootjpa.Controller;

import com.test.springbootjpa.Model.Talaba;
import com.test.springbootjpa.Repository.Talaba_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    Talaba_repository talaba_repository;

    @RequestMapping(value = "/talaba", method = RequestMethod.GET)
    public List<Talaba> malumotOqish(){
        List<Talaba> talabaList = talaba_repository.findAll();
        return talabaList;
    }
    @RequestMapping(value = "/talaba", method = RequestMethod.POST)
    public String malumotJoylash(@RequestBody Talaba talaba){
        talaba_repository.save(talaba);
        return "Ma'lumot joylandi";
    }
    @RequestMapping (value = "/talaba/{id}", method = RequestMethod.GET)
    public Talaba idChiqarish(@PathVariable Integer id){
        Optional<Talaba> optionalTalaba = talaba_repository.findById(id);
        if (optionalTalaba.isPresent()){
            return optionalTalaba.get();
        }
        return new Talaba();
    }
    @RequestMapping (value = "/talaba/{id}", method = RequestMethod.DELETE)
    public String idOchirish
            (@PathVariable Integer id){
        Optional<Talaba> optionalTalaba = talaba_repository.findById(id);
        if (optionalTalaba.isPresent()){
            talaba_repository.deleteById(id);
            return "Ma'lumot o'chirildi";
        }
        return "Topilmadi";
    }

    @RequestMapping (value = "/talaba/{id}", method = RequestMethod.PUT)
    public String idTahrirlash(@PathVariable Integer id, @RequestBody Talaba talaba){
        Optional<Talaba> optionalTalaba = talaba_repository.findById(id);
        boolean holat=false;

            if (optionalTalaba.isPresent()){
                Talaba talaba1 = optionalTalaba.get();
                talaba1.setFamilya(talaba.getFamilya());
                talaba1.setIsm(talaba.getIsm());
                talaba1.setTelefon(talaba.getTelefon());
                talaba1.setTugilgan_kun(talaba.getTugilgan_kun());
                talaba_repository.save(talaba1);
                holat=true;
        }
        return holat ? "Muvaffaqiyatli yangilandi":"Ma'lumot topilmadi";
    }
}
