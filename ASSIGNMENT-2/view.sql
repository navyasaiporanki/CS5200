    create view developer_roles_and_privileges as 
    select   first_name, last_name, username, email, website.name,website.visits, website.updated,
  wr.role, wp.priviledge, page.title, page.visits as page_visits, page.updated as page_updated , pr.role as page_role,
  pp.priviledge as page_priviledge from
   person p join developer d on p.id= d.id 
   join website_role wr on (p.id = wr.developer_id)
   join website  on (website.id = wr.website_id)
    join website_priviledge wp on (wp.developer_id = wr.developer_id and wp.website_id = wr.website_id)
   left join page on (page.id = website.id)
   left join page_role pr on (pr.developer_id  = p.id and pr.page_id = page.id)
    left join page_priviledge pp on (pp.page_id = pr.page_id and pr.developer_id = pp.developer_id)
   order by first_name,website.name;