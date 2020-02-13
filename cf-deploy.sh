cf target -o dbs -s development

cf push -f ./customer/manifest.yml
cf push -f ./banking-transaction/manifest.yml
cf push -f ./account/manifest.yml