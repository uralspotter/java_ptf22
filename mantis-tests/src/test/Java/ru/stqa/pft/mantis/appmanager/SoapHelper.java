package ru.stqa.pft.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {

    private ApplicationManager app;

    public SoapHelper(ApplicationManager app) {
        this.app = app;
    }

    public Set<Project> getProjects() throws RemoteException, MalformedURLException, ServiceException {
        MantisConnectPortType mc = getMantisConnectPort();
        ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator", "root");
        return Arrays.asList(projects).stream().map((p) -> new Project().withId(p.getId().intValue()).withName(p.getName())).collect(Collectors.toSet());
    }

    private MantisConnectPortType getMantisConnectPort() throws ServiceException, MalformedURLException {
        return new MantisConnectLocator().getMantisConnectPort(new URL(app.getProperty("soap.host")));
    }

    public Issue addIssue(Issue issue) throws ServiceException, MalformedURLException, RemoteException {
        MantisConnectPortType mc = getMantisConnectPort();
        String[] categories = mc.mc_project_get_categories("administrator", "root", BigInteger.valueOf(issue.getProject().getId()));
        IssueData issueData = new IssueData();
        issueData.setSummary(issue.getSummary());
        issueData.setDescription(issue.getDescription());
        issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName()));
        issueData.setCategory(categories[0]);
        BigInteger issueid = mc.mc_issue_add("administrator", "root", issueData);
        IssueData createdIssueData = mc.mc_issue_get("administrator", "root", issueid);
        return new Issue().withId(createdIssueData.getId().intValue()).withSummary(createdIssueData.getSummary()).withDescription(createdIssueData.getDescription()).withProject(new Project().withId(createdIssueData.getProject().getId().intValue()).withName(createdIssueData.getProject().getName()));
    }

    public boolean getIssueStatus(int issueId) throws ServiceException, MalformedURLException, RemoteException {
        MantisConnectPortType mc = getMantisConnectPort();
        ObjectRef issueStatus = mc.mc_issue_get("adminstrator", "root", BigInteger.valueOf(issueId)).getStatus();
        if (issueStatus.equals(80) || issueStatus.equals(90)) {
            return true;
        } else {
            return false;
        }
    }
}
