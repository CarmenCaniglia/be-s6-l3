package epicode.u5d7hw.services;

import epicode.u5d7hw.entities.Author;
import epicode.u5d7hw.entities.Blogpost;
import epicode.u5d7hw.exceptions.NotFoundException;
import epicode.u5d7hw.repositories.BlogpostsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogsService {
    @Autowired
    private BlogpostsDAO blogpostsDAO;

    public Blogpost save(Blogpost blogpost) {
        return blogpostsDAO.save(blogpost);
    }

    public List<Blogpost> getBlogs() {
        return blogpostsDAO.findAll();
    }

    public Blogpost findById(int id) {
        return blogpostsDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(int id) {
        Blogpost found = this.findById(id);
        blogpostsDAO.delete(found);
    }

    public Blogpost findByIdAndUpdate(int id, Blogpost body) {
        Blogpost found = this.findById(id);
        found.setCover(body.getCover());
        found.setCategory(body.getCategory());
        found.setContent(body.getCover());
        found.setReadingTime(body.getReadingTime());
        found.setTitle(body.getTitle());
        return blogpostsDAO.save(found);
    }
}
