import {VirtualNode} from "../models/Inv";
import {TableConfiguration} from "../models/table";
import {FaArrowDown, FaArrowUp} from "react-icons/fa";
import {TablePage} from "../components/pages/TablePage";
import {useContext} from "react";
import {DialogContext, UIContext} from "../UIContext";

export const InventoryPage = () => {

    const dialogContext = useContext(DialogContext);

    const conf : TableConfiguration = {
        filterOpts: {},
        url: "/api/inv/vm",
        dataClass: VirtualNode,
        parseFunc: (rowData: VirtualNode) : VirtualNode => {
            rowData.ramSizeInGB = VirtualNode.getRamSizeInGB(rowData.ramSize);
            rowData.ipWithIcon = (
                <span style={{ display: "flex", alignItems: "center", gap: "0.3rem" }}>
                    {rowData.ipAddress.ip}
                            {rowData.isCpuPinned ? (
                                <FaArrowUp color="green" />
                            ) : (
                                <FaArrowDown color="red" />
                            )}
                </span>
            );
            rowData.host = (<span className={"cursor-pointer"} onClick={() => {
                dialogContext.setDialogTitle("Host Data");
                dialogContext.setDialogContent(<div>
                    <p><span className={"text-blue-500"}>Host Name: </span>{rowData.physicalNode.label}</p>
                    <p><span className={"text-blue-500"}>IP: </span>{rowData.physicalNode.ipAddress.ip}</p>
                    <p><span className={"text-blue-500"}>RAM Size: </span>{VirtualNode.getRamSizeInGB(rowData.physicalNode.ramSize.toString())}</p>
                    <p><span className={"text-blue-500"}>Chassis Serial No: </span>{rowData.physicalNode.chassisSerialNumber}</p>
                </div>);
                dialogContext.setDialogOpen(true);
                console.log(rowData);
            } }>{rowData.physicalNode.ipAddress.ip}</span>);
            return rowData;
        },
        columnMetaData: {
            "VM Name": {
                key: "vmName", filterKey: "vmName"
            },
            "VM Label": {
                key: "label", filterKey: "label"
            },
            "IP Address": {
                key: "ipWithIcon", filterKey: "ipAddress.ip"
            },
            "Host": {
                key: "host", filterKey: "host"
            },
            "Subnet": {
                key: "ipAddress.subnet.name", filterKey: "ipAddress.subnet.name"
            },
            "RAM Size(GB/TB)": {
                key: "ramSizeInGB", filterKey: "ramSize"
            },
            "bootMode": {
                key: "bootMode", filterKey: "bootMode"
            }
        }
    }

    return (
        <TablePage conf={conf} />
    );
};
