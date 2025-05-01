import {TableConfiguration} from "../../models/table";
import {useEffect, useState} from "react";
import axios from "axios";
import {BACKEND_URL} from "../../constant";
import {Table} from "../table/Table";

export const TablePage = ({ conf } : { conf: TableConfiguration }) => {

    const { dataClass } = conf;

    const [data, setData] = useState<InstanceType<typeof dataClass>>([]);
    const [loading, setLoading] = useState(true);

    const fetchData = async () => {
        const token : string = sessionStorage?.token;
        setData([]);
        await axios.get(BACKEND_URL + conf.url,
            {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            })
            .then((response) => {
                setData(response.data);
                setLoading(false);
            })
            .catch((error) => {
                console.log(error);
                setLoading(false);
            })
    }

    useEffect(() => {
        fetchData();
    }, []);

    return (
            loading ? <div className={"loader"}></div> : <Table conf={conf} data={data} />
    );
};
