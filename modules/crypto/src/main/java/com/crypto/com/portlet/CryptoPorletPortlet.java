package com.crypto.com.portlet;

import com.crypto.com.constants.CryptoPorletPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author frank
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CryptoPorlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CryptoPorletPortletKeys.CRYPTOPORLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CryptoPorletPortlet extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(CryptoPorletPortlet.class);

	@Override
	public void init() throws PortletException {
		super.init();
		LOG.debug("INIT");
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		LOG.debug("PROCESS ACTION");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		int age = ParamUtil.getInteger(actionRequest, "age");
		String messageResponse = String.format("Hi, mi nmae is %s I am %d", firstName, age);
		actionRequest.setAttribute("messageResponse", messageResponse);
		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		LOG.debug("RENDER");
		renderRequest.setAttribute("message", "hi there");
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void destroy() {
		super.destroy();
		LOG.debug("DESTROY");
	}
}