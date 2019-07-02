package java.gabi.controllers;

import java.gabi.domain.Category;
import java.gabi.domain.UnitOfMeasure;
import java.gabi.repositories.CategoryRepository;
import java.gabi.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    //private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;


//    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
//        this.categoryRepository = categoryRepository;
//        this.unitOfMeasureRepository = unitOfMeasureRepository;
//    }


    @RequestMapping({"","/","index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        //logger.info("Category id is: "+categoryOptional.get().getId());
        //logger.info("Unit of measure id is: "+unitOfMeasureOptional.get().getId());

        return "index";
    }
}
