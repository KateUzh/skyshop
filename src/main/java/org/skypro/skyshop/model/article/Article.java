package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable {
    private final String titleOfArticle;
    private final String textOfArticle;
    private final UUID id;

    public Article(String titleOfArticle, String textOfArticle, UUID id) {
        this.titleOfArticle = titleOfArticle;
        this.textOfArticle = textOfArticle;
        this.id = id;
    }

    public String toString() {
        return this.titleOfArticle + ", " + this.textOfArticle;
    }

    @Override
    @JsonIgnore
    public String getSearchTerm() {
        return toString();
    }

    @Override
    @JsonIgnore
    public String typeContent() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(titleOfArticle, article.titleOfArticle) && Objects.equals(textOfArticle, article.textOfArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleOfArticle, textOfArticle);
    }

    @Override
    public UUID getId() {
        return id;
    }
}
