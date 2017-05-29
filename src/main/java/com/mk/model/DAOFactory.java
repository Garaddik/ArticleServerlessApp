package com.mk.model;

import com.mk.dao.ArticleDAO;
import com.mk.dao.ArticleDAOImpl;

/**
 * 
 * @author kirankumar.garaddi
 *
 */
public class DAOFactory {
    /**
     * Contains the implementations of the DAO objects. By default we only have a DynamoDB implementation
     */
    public enum DAOType {
        DynamoDB
    }

   
    /**
     * Returns the default PetDAO implementation
     *
     * @return The DynamoDB PetDAO implementation
     */
    public static ArticleDAO getArticleDAO() {
        return getArticleDAO(DAOType.DynamoDB);
    }

    /**
     * Returns a PetDAO implementation
     *
     * @param daoType The implementation type
     * @return The requested DAO implementation
     */
    public static ArticleDAO getArticleDAO(DAOType daoType) {
        ArticleDAO dao = null;
        switch (daoType) {
            case DynamoDB:
                dao = ArticleDAOImpl.getInstance();
                break;
        }

        return dao;
    }
}
