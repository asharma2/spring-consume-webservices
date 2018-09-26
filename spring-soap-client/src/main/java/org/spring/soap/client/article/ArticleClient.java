package org.spring.soap.client.article;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.spring.soap.article.AddArticleRequest;
import com.spring.soap.article.AddArticleResponse;
import com.spring.soap.article.ArticleInfo;
import com.spring.soap.article.DeleteArticleRequest;
import com.spring.soap.article.DeleteArticleResponse;
import com.spring.soap.article.GetAllArticlesRequest;
import com.spring.soap.article.GetAllArticlesResponse;
import com.spring.soap.article.GetArticleByIdRequest;
import com.spring.soap.article.GetArticleByIdResponse;
import com.spring.soap.article.UpdateArticleRequest;
import com.spring.soap.article.UpdateArticleResponse;

public class ArticleClient extends WebServiceGatewaySupport {

	public GetArticleByIdResponse getArticleById(long articleId) {
		GetArticleByIdRequest request = new GetArticleByIdRequest();
		request.setArticleId(articleId);
		GetArticleByIdResponse response = (GetArticleByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request,
		        new SoapActionCallback("http://localhost:8080/ws/getArticleByIdRequest"));
		return response;
	}

	public GetAllArticlesResponse getAllArticles() {
		GetAllArticlesRequest request = new GetAllArticlesRequest();
		GetAllArticlesResponse response = (GetAllArticlesResponse) getWebServiceTemplate().marshalSendAndReceive(request,
		        new SoapActionCallback("http://localhost:8080/ws/getAllArticlesRequest"));
		return response;
	}

	public AddArticleResponse addArticle(String title, String category) {
		AddArticleRequest request = new AddArticleRequest();
		request.setTitle(title);
		request.setCategory(category);
		AddArticleResponse response = (AddArticleResponse) getWebServiceTemplate().marshalSendAndReceive(request,
		        new SoapActionCallback("http://localhost:8080/ws/addArticleRequest"));
		return response;
	}

	public UpdateArticleResponse updateArticle(ArticleInfo articleInfo) {
		UpdateArticleRequest request = new UpdateArticleRequest();
		request.setArticleInfo(articleInfo);
		UpdateArticleResponse response = (UpdateArticleResponse) getWebServiceTemplate().marshalSendAndReceive(request,
		        new SoapActionCallback("http://localhost:8080/ws/updateArticleRequest"));
		return response;
	}

	public DeleteArticleResponse deleteArticle(long articleId) {
		DeleteArticleRequest request = new DeleteArticleRequest();
		request.setArticleId(articleId);
		DeleteArticleResponse response = (DeleteArticleResponse) getWebServiceTemplate().marshalSendAndReceive(request,
		        new SoapActionCallback("http://localhost:8080/ws/deleteArticleRequest"));
		return response;
	}
}
