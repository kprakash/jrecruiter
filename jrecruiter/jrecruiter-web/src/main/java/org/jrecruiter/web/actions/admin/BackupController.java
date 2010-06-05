package org.jrecruiter.web.actions.admin;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.jrecruiter.dao.IndustryDao;
import org.jrecruiter.dao.JobCountPerDayDao;
import org.jrecruiter.dao.RegionDao;
import org.jrecruiter.dao.RoleDao;
import org.jrecruiter.model.ServerSettings;
import org.jrecruiter.model.export.Backup;
import org.jrecruiter.service.DemoService;
import org.jrecruiter.service.JobService;
import org.jrecruiter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Retrieves all jobs and returns an XML document. The structure conforms to the layout
 * defined by Indeed.com
 *
 * @author Gunnar Hillert
 * @version $Id:UserService.java 128 2007-07-27 03:55:54Z ghillert $
 */
@Controller
public class BackupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BackupController.class);

    private @Autowired DemoService demoService;
    private @Autowired JobService jobService;
    private @Autowired RoleDao roleDao;
    private @Autowired RegionDao regionDao;
    private @Autowired IndustryDao industryDao;
    private @Autowired JobCountPerDayDao jobCountPerDayDao;
    private @Autowired UserService userService;
    private @Autowired ServerSettings serverSettings;
    private @Autowired Jaxb2Marshaller marshaller;
    private @Autowired CommonsMultipartResolver multipartResolver;


    private static final long serialVersionUID = -3422780336408883930L;

    @RequestMapping("/admin/backup.xml")
    public void backup(ModelMap model, OutputStream out) throws JAXBException {

        Backup backup = new Backup();
        backup.setJobCountPerDay(jobCountPerDayDao.getAll());
        backup.setIndustries(jobService.getIndustries());
        backup.setRegions(jobService.getRegions());
        backup.setRoles(roleDao.getAll());
        backup.setUsers(userService.getAllUsers());
        backup.setJobs(jobService.getJobs());

        marshaller.marshal(backup, new StreamResult(out));

    }

    @RequestMapping(value="/admin/restore", method = RequestMethod.GET)
    public String restore() throws JAXBException, IOException {

        return "admin/restore";

    }

    @Transactional
    @RequestMapping(value="/admin/restore", method = RequestMethod.POST)
    public String restore(@RequestParam("file") MultipartFile file) throws JAXBException, IOException {

        if (!file.isEmpty()) {
            demoService.restore(file.getInputStream());

        } else {

        }

        return "redirect:../../admin/index.html";

    }

}